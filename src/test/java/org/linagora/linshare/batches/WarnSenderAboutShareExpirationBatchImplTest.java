/*
 * LinShare is an open source filesharing software, part of the LinPKI software
 * suite, developed by Linagora.
 * 
 * Copyright (C) 2017 LINAGORA
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version, provided you comply with the Additional Terms applicable for
 * LinShare software by Linagora pursuant to Section 7 of the GNU Affero General
 * Public License, subsections (b), (c), and (e), pursuant to which you must
 * notably (i) retain the display of the “LinShare™” trademark/logo at the top
 * of the interface window, the display of the “You are using the Open Source
 * and free version of LinShare™, powered by Linagora © 2009–2017. Contribute to
 * Linshare R&D by subscribing to an Enterprise offer!” infobox and in the
 * e-mails sent with the Program, (ii) retain all hypertext links between
 * LinShare and linshare.org, between linagora.com and Linagora, and (iii)
 * refrain from infringing Linagora intellectual property rights over its
 * trademarks and commercial brands. Other Additional Terms apply, see
 * <http://www.linagora.com/licenses/> for more details.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Affero General Public License and
 * its applicable Additional Terms for LinShare along with this program. If not,
 * see <http://www.gnu.org/licenses/> for the GNU Affero General Public License
 * version 3 and <http://www.linagora.com/licenses/> for the Additional Terms
 * applicable to LinShare software.
 */

package org.linagora.linshare.batches;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.linagora.linshare.core.batches.GenericBatch;
import org.linagora.linshare.core.business.service.DocumentEntryBusinessService;
import org.linagora.linshare.core.business.service.ShareEntryGroupBusinessService;
import org.linagora.linshare.core.domain.constants.LinShareTestConstants;
import org.linagora.linshare.core.domain.entities.Account;
import org.linagora.linshare.core.domain.entities.DocumentEntry;
import org.linagora.linshare.core.domain.entities.User;
import org.linagora.linshare.core.domain.objects.ShareContainer;
import org.linagora.linshare.core.exception.BatchBusinessException;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.repository.UserRepository;
import org.linagora.linshare.core.runner.BatchRunner;
import org.linagora.linshare.core.service.ShareService;
import org.linagora.linshare.service.LoadingServiceTestDatas;
import org.linagora.linshare.utils.LinShareWiser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.google.common.collect.Lists;

@ContextConfiguration(locations = { "classpath:springContext-datasource.xml",
		"classpath:springContext-dao.xml",
		"classpath:springContext-ldap.xml",
		"classpath:springContext-fongo.xml",
		"classpath:springContext-storage-jcloud.xml",
		"classpath:springContext-repository.xml",
		"classpath:springContext-business-service.xml",
		"classpath:springContext-rac.xml",
		"classpath:springContext-service-miscellaneous.xml",
		"classpath:springContext-service.xml",
		"classpath:springContext-batches.xml",
		"classpath:springContext-test.xml" })
public class WarnSenderAboutShareExpirationBatchImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static Logger logger = LoggerFactory.getLogger(WarnSenderAboutShareExpirationBatchImplTest.class);

	@Autowired
	private BatchRunner batchRunner;

	@Autowired
	@Qualifier("warnSenderAboutShareExpirationWithoutDownloadBatch")
	private GenericBatch warnSenderAboutShareExpirationWithoutDownloadBatch;

	@Autowired
	@Qualifier("shareEntryGroupBusinessService")
	private ShareEntryGroupBusinessService shareEntryGroupBusinessService;

	@Autowired
	private DocumentEntryBusinessService documentEntryBusinessService;

	@Autowired
	@Qualifier("shareService")
	private ShareService shareService;

	@Autowired
	@Qualifier("userRepository")
	private UserRepository<User> userRepository;

	private LoadingServiceTestDatas datas;

	private User owner;

	private Account actor;

	private User recipient;

	private LinShareWiser wiser;

	public WarnSenderAboutShareExpirationBatchImplTest() {
		super();
		wiser = new LinShareWiser(2525);
	}

	@Before
	public void setUp() throws Exception {
		logger.debug(LinShareTestConstants.BEGIN_SETUP);
		wiser.start();
		datas = new LoadingServiceTestDatas(userRepository);
		datas.loadUsers();
		owner = datas.getUser1();
		actor = (Account) owner;
		recipient = datas.getUser2();
		initShareEntryGroupe();
		logger.debug(LinShareTestConstants.END_SETUP);
	}

	@After
	public void tearDown() throws Exception {
		logger.debug(LinShareTestConstants.BEGIN_TEARDOWN);
		wiser.stop();
		logger.debug(LinShareTestConstants.END_TEARDOWN);
	}

	@Test
	public void testWarnOwnerGuestExpiration() throws BusinessException, BatchBusinessException {
		List<GenericBatch> batches = Lists.newArrayList();
		batches.add(warnSenderAboutShareExpirationWithoutDownloadBatch);
		Assert.assertTrue("At least one batch failed.", batchRunner.execute(batches));
		wiser.checkGeneratedMessages();
	}

	private void initShareEntryGroupe() throws IOException {
		File tempFile = File.createTempFile("linshare-test-", ".tmp");
		Calendar documentEntryExpiration = Calendar.getInstance();
		DocumentEntry documentEntry = documentEntryBusinessService.createDocumentEntry(owner, tempFile,
				tempFile.length(), "shareFile", null, false, null, "text/plain", documentEntryExpiration, false, null);
		ShareContainer shareContainer = new ShareContainer();
		Calendar expirationDate = Calendar.getInstance();
		expirationDate.add(Calendar.DATE, 7);
		shareContainer.setExpiryDate(expirationDate.getTime());
		shareContainer.addShareRecipient(recipient);
		shareContainer.addDocumentEntry(documentEntry);
		shareService.create(actor, owner, shareContainer);
	}

}
