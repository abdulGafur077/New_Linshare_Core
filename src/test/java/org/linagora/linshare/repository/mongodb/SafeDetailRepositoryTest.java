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
package org.linagora.linshare.repository.mongodb;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.linagora.linshare.core.domain.constants.Language;
import org.linagora.linshare.core.domain.constants.SupportedLanguage;
import org.linagora.linshare.core.domain.entities.AbstractDomain;
import org.linagora.linshare.core.domain.entities.DomainPolicy;
import org.linagora.linshare.core.domain.entities.GuestDomain;
import org.linagora.linshare.core.domain.entities.Internal;
import org.linagora.linshare.core.domain.entities.WorkGroup;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.repository.AbstractDomainRepository;
import org.linagora.linshare.core.repository.DomainPolicyRepository;
import org.linagora.linshare.core.repository.InternalRepository;
import org.linagora.linshare.core.repository.ThreadRepository;
import org.linagora.linshare.mongo.entities.SafeDetail;
import org.linagora.linshare.mongo.repository.SafeDetailMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = {
		"classpath:springContext-datasource.xml",
		"classpath:springContext-repository.xml",
		"classpath:springContext-dao.xml",
		"classpath:springContext-ldap.xml",
		"classpath:springContext-service.xml",
		"classpath:springContext-business-service.xml",
		"classpath:springContext-service-miscellaneous.xml",
		"classpath:springContext-rac.xml",
		"classpath:springContext-fongo.xml",
		"classpath:springContext-storage-jcloud.xml",
		"classpath:springContext-test.xml" })
public class SafeDetailRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	private final static String THREAD_NAME = "threadName";
	private final static String EMAIL1 = "anakin.skywalker@int4.linshare.dev";
	private final static String CMIS_LOCALE = "cmis";
	private final static String DESCRIPTION = "This is an optional description";
	private final static String DOMAIN_POLICY_UUID = "DefaultDomainPolicy";

	@Autowired
	private InternalRepository internalRepository;

	@Autowired
	private SafeDetailMongoRepository safeDetailMongoRepository;
	
	@Autowired
	private ThreadRepository threadRepository;
	
	@Autowired
	private AbstractDomainRepository abstractDomainRepository;

	@Autowired
	private DomainPolicyRepository domainPolicyRepository;
			
	private Internal internal;
	
	private WorkGroup workGroup;
	
	private AbstractDomain testDomain;

	private DomainPolicy defaultPolicy;
	
	@Before
	public void setUp() throws Exception {
		logger.debug("Begin setUp");
		defaultPolicy = domainPolicyRepository.findById(DOMAIN_POLICY_UUID);
		testDomain = createATestDomain();
		
		internal = new Internal();		
		internal.setMail(EMAIL1);
		internal.setLocale(SupportedLanguage.ENGLISH);
		internal.setCmisLocale(CMIS_LOCALE);
		internal.setDomain(testDomain);
		internal = internalRepository.create(internal);
		

		workGroup = new WorkGroup();
		workGroup.setLocale(SupportedLanguage.ENGLISH);
		workGroup.setExternalMailLocale(Language.ENGLISH);
		workGroup.setCmisLocale(CMIS_LOCALE);
		workGroup.setDomain(testDomain);
		workGroup.setName(THREAD_NAME);
		workGroup = threadRepository.create(workGroup);
	}

	@After
	public void tearDown() throws Exception {
		logger.debug("Begin tearDown");
		internalRepository.delete(internal);
		abstractDomainRepository.delete(testDomain);
		logger.debug("End tearDown");
	}
	
	private AbstractDomain createATestDomain() throws BusinessException {
		AbstractDomain currentTopDomain = new GuestDomain("My Guest domain");
		currentTopDomain.setPolicy(defaultPolicy);
		abstractDomainRepository.create(currentTopDomain);
		logger.debug("Current TopDomain object: " + currentTopDomain.toString());
		return currentTopDomain;
	}

	@Test
	public void testCreateSafeDetail() {
		SafeDetail safeDetail = new SafeDetail(internal.getLsUuid(), workGroup.getLsUuid(), DESCRIPTION);
		safeDetail = safeDetailMongoRepository.insert(safeDetail);
		Assert.assertEquals(safeDetail.getAccountUuid(), internal.getLsUuid());
		safeDetailMongoRepository.delete(safeDetail.getUuid());
	}

	@Test
	public void testDeleteSafeDetail() {
		SafeDetail safeDetail = new SafeDetail(internal.getLsUuid(), workGroup.getLsUuid(), DESCRIPTION);
		safeDetail = safeDetailMongoRepository.insert(safeDetail);
		Assert.assertEquals(safeDetail.getAccountUuid(), internal.getLsUuid());
		safeDetailMongoRepository.delete(safeDetail);
		Assert.assertNull(safeDetailMongoRepository.findByAccountUuid(internal.getLsUuid()));
	}
	
	@Test
	public void testfindAll() {
		SafeDetail safeDetail = new SafeDetail(internal.getLsUuid(), workGroup.getLsUuid(), DESCRIPTION);
		safeDetailMongoRepository.insert(safeDetail);
		SafeDetail exist = safeDetailMongoRepository.findByAccountUuid(internal.getLsUuid());
		Assert.assertEquals(exist.getAccountUuid() , internal.getLsUuid());
		safeDetailMongoRepository.delete(safeDetail.getUuid());
	}
}
