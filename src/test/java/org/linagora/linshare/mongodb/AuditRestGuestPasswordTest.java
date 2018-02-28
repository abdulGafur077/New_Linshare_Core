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
 * and free version of LinShare™, powered by Linagora © 2009–2015. Contribute to
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
package org.linagora.linshare.mongodb;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.linagora.linshare.core.domain.constants.LogAction;
import org.linagora.linshare.core.domain.constants.ResetTokenKind;
import org.linagora.linshare.core.domain.constants.SupportedLanguage;
import org.linagora.linshare.core.domain.entities.AbstractDomain;
import org.linagora.linshare.core.domain.entities.Guest;
import org.linagora.linshare.core.domain.entities.SystemAccount;
import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.repository.AbstractDomainRepository;
import org.linagora.linshare.core.repository.GuestRepository;
import org.linagora.linshare.core.service.GuestService;
import org.linagora.linshare.core.service.ResetGuestPasswordService;
import org.linagora.linshare.mongo.entities.ResetGuestPassword;
import org.linagora.linshare.mongo.repository.AuditUserMongoRepository;
import org.linagora.linshare.mongo.repository.ResetGuestPasswordMongoRepository;
import org.linagora.linshare.service.LoadingServiceTestDatas;
import org.linagora.linshare.utils.LinShareWiser;
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
public class AuditRestGuestPasswordTest extends AbstractTransactionalJUnit4SpringContextTests {

	private final static String FIRST_NAME = "givenName";
	private final static String LAST_NAME = "lastName";
	private final static String EMAIL = "anakin.skywalker@int4.linshare.dev";
	private final static String UUID = "uuid";
	private final static String CMIS_LOCALE = "cmis";
	private final static String NEW_PASSWORD ="root";
	
	@Autowired
	private ResetGuestPasswordService resetGuestPasswordService;

	@Autowired
	private GuestService guestService;

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private AbstractDomainRepository abstractDomainRepository;

	@Autowired
	private AuditUserMongoRepository userMongoRepository;

	@Autowired
	private ResetGuestPasswordMongoRepository resetGuestPasswordMongoRepository;

	private Guest guest;

	private AbstractDomain guestDomain;

	private ResetGuestPassword resetGuestPassword;

	private SystemAccount actor;

	private LinShareWiser wiser;

	public AuditRestGuestPasswordTest() {
		super();
		wiser = new LinShareWiser(2525);
	}

	@Before
	public void setUp() throws Exception {
		logger.debug("Begin setUp");
		guestDomain = abstractDomainRepository.findById(LoadingServiceTestDatas.sqlGuestDomain);
		guest = new Guest(FIRST_NAME, LAST_NAME, EMAIL);
		guest.setLsUuid(UUID);
		guest.setLocale(SupportedLanguage.ENGLISH);
		guest.setCmisLocale(CMIS_LOCALE);
		guest.setDomain(guestDomain);
		guest.setOwner(resetGuestPasswordService.getGuestSystemAccount());
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.MONTH, 3);
		guest.setExpirationDate(instance.getTime());
		guest = guestRepository.create(guest);
		resetGuestPassword = new ResetGuestPassword(guest);
		resetGuestPassword.setKind(ResetTokenKind.RESET_PASSWORD);
		resetGuestPassword = resetGuestPasswordMongoRepository.insert(resetGuestPassword);
		actor = resetGuestPasswordService.getGuestSystemAccount();
		wiser.start();
	}

	@After
	public void tearDown() throws Exception {
		logger.debug("Begin tearDown");
		resetGuestPasswordMongoRepository.delete(resetGuestPassword);
		guestRepository.delete(guest);
		abstractDomainRepository.delete(guestDomain);
		wiser.stop();
		logger.debug("End tearDown");
	}

	@Test
	public void testAuditInvalidToken() {
		int initialSize = userMongoRepository.findByAction(String.valueOf(LogAction.FAILURE)).size();
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.HOUR, -1);
		resetGuestPassword.setExpirationDate(instance.getTime());
		resetGuestPassword = resetGuestPasswordMongoRepository.save(resetGuestPassword);
		try {
			resetGuestPasswordService.find(actor, actor, resetGuestPassword.getUuid());
		} catch (BusinessException e) {
			logger.debug("The reset token is expired.");
		}
		assertEquals(initialSize + 1, userMongoRepository.findByAction(String.valueOf(LogAction.FAILURE)).size());
	}

	@Test
	public void testAuditAttemptToResetPowssword() {
		int initialSize = userMongoRepository.findByAction(String.valueOf(LogAction.CREATE)).size();
		try {
			guestService.triggerResetPassword(actor, EMAIL, guestDomain.getUuid());
		} catch (Exception e) {
		}
		assertEquals(initialSize + 1, userMongoRepository.findByAction(String.valueOf(LogAction.CREATE)).size());
	}

	@Test
	public void testAuditPawsswordResetedSuccessfully() {
		int initialSize = userMongoRepository.findByAction(String.valueOf(LogAction.SUCCESS)).size();
		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.HOUR, +1);
		resetGuestPassword.setExpirationDate(instance.getTime());
		resetGuestPassword.setPassword(NEW_PASSWORD);
		resetGuestPassword = resetGuestPasswordMongoRepository.save(resetGuestPassword);
		resetGuestPasswordService.update(actor, actor, resetGuestPassword);
		assertEquals(initialSize + 1, userMongoRepository.findByAction(String.valueOf(LogAction.SUCCESS)).size());
		wiser.checkGeneratedMessages();
	}
}
