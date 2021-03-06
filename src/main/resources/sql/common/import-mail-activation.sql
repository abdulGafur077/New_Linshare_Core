
-- MailActivation : FILE_WARN_OWNER_BEFORE_FILE_EXPIRY
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (137, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (138, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (139, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(1, false, 'FILE_WARN_OWNER_BEFORE_FILE_EXPIRY', 137, 138, 139, 1, true);

-- MailActivation : SHARE_NEW_SHARE_FOR_RECIPIENT
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (140, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (141, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (142, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
	VALUES(2, false, 'SHARE_NEW_SHARE_FOR_RECIPIENT', 140, 141, 142, 1, true);

-- MailActivation : SHARE_NEW_SHARE_ACKNOWLEDGEMENT_FOR_SENDER
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (143, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (144, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (145, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(3, false, 'SHARE_NEW_SHARE_ACKNOWLEDGEMENT_FOR_SENDER', 143, 144, 145, 1, true);

-- MailActivation : SHARE_FILE_DOWNLOAD_ANONYMOUS
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (146, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (147, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (148, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(4, false, 'SHARE_FILE_DOWNLOAD_ANONYMOUS', 146, 147, 148, 1, true);

-- MailActivation : SHARE_FILE_DOWNLOAD_USERS
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (149, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (150, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (151, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(5, false, 'SHARE_FILE_DOWNLOAD_USERS', 149, 150, 151, 1, true);

-- MailActivation : SHARE_FILE_SHARE_DELETED
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (152, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (153, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (154, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(6, false, 'SHARE_FILE_SHARE_DELETED', 152, 153, 154, 1, true);

-- MailActivation : SHARE_WARN_RECIPIENT_BEFORE_EXPIRY
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (155, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (156, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (157, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(7, false, 'SHARE_WARN_RECIPIENT_BEFORE_EXPIRY', 155, 156, 157, 1, true);

-- MailActivation : SHARE_WARN_UNDOWNLOADED_FILESHARES
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (158, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (159, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (160, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(8, false, 'SHARE_WARN_UNDOWNLOADED_FILESHARES', 158, 159, 160, 1, true);

-- MailActivation : GUEST_ACCOUNT_NEW_CREATION
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (161, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (162, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (163, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(9, false, 'GUEST_ACCOUNT_NEW_CREATION', 161, 162, 163, 1, true);

-- MailActivation : GUEST_ACCOUNT_RESET_PASSWORD_LINK
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (164, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (165, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (166, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(10, false, 'GUEST_ACCOUNT_RESET_PASSWORD_LINK', 164, 165, 166, 1, true);

-- MailActivation : UPLOAD_REQUEST_UPLOADED_FILE
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (167, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (168, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (169, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(11, false, 'UPLOAD_REQUEST_UPLOADED_FILE', 167, 168, 169, 1, true);

-- MailActivation : UPLOAD_REQUEST_UNAVAILABLE_SPACE
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (170, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (171, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (172, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(12, false, 'UPLOAD_REQUEST_UNAVAILABLE_SPACE', 170, 171, 172, 1, true);

-- MailActivation : UPLOAD_REQUEST_WARN_BEFORE_EXPIRY
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (173, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (174, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (175, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(13, false, 'UPLOAD_REQUEST_WARN_BEFORE_EXPIRY', 173, 174, 175, 1, true);

-- MailActivation : UPLOAD_REQUEST_WARN_EXPIRY
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (176, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (177, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (178, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(14, false, 'UPLOAD_REQUEST_WARN_EXPIRY', 176, 177, 178, 1, true);

-- MailActivation : UPLOAD_REQUEST_CLOSED_BY_RECIPIENT
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (179, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (180, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (181, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(15, false, 'UPLOAD_REQUEST_CLOSED_BY_RECIPIENT', 179, 180, 181, 1, true);

-- MailActivation : UPLOAD_REQUEST_FILE_DELETED_BY_RECIPIENT
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (182, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (183, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (184, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(16, false, 'UPLOAD_REQUEST_FILE_DELETED_BY_RECIPIENT', 182, 183, 184, 1, true);

INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (231, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (232, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (233, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(17, false, 'UPLOAD_REQUEST_ACTIVATED_FOR_RECIPIENT', 231, 232, 233, 1, true);

INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (234, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (235, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (236, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(18, false, 'UPLOAD_REQUEST_ACTIVATED_FOR_OWNER', 234, 235, 236, 1, true);

INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (237, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (238, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (239, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(19, false, 'UPLOAD_REQUEST_REMINDER', 237, 238, 239, 1, true);

INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (240, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (241, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (242, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(20, false, 'UPLOAD_REQUEST_PASSWORD_RENEWAL', 240, 241, 242, 1, true);

INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (243, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (244, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (245, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(21, false, 'UPLOAD_REQUEST_CREATED', 243, 244, 245, 1, true);

INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (246, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (247, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (248, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(22, false, 'UPLOAD_REQUEST_CLOSED_BY_OWNER', 246, 247, 248, 1, true);

INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (249, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (250, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (251, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(23, false, 'UPLOAD_REQUEST_RECIPIENT_REMOVED', 249, 250, 251, 1, true);

INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (252, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (253, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (254, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(24, false, 'UPLOAD_REQUEST_UPDATED_SETTINGS', 252, 253, 254, 1, true);

INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (255, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (256, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (257, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(25, false, 'UPLOAD_REQUEST_FILE_DELETED_BY_OWNER', 255, 256, 257, 1, true);

INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (258, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (259, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (260, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(26, false, 'GUEST_WARN_OWNER_ABOUT_GUEST_EXPIRATION', 258, 259, 260, 1, true);

-- MailActivation : SHARE_WARN_SENDER_ABOUT_SHARE_EXPIRATION_WITHOUT_DOWNLOAD
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (261, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (262, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (263, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)
 	VALUES(27, false, 'SHARE_WARN_SENDER_ABOUT_SHARE_EXPIRATION_WITHOUT_DOWNLOAD', 261, 262, 263, 1, true);

-- MailActivation : SHARE_WARN_RECIPIENT_ABOUT_EXPIRED_SHARE
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (264, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (265, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (266, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable) 
 	VALUES(28, false, 'SHARE_WARN_RECIPIENT_ABOUT_EXPIRED_SHARE', 264, 265, 266, 1, true);

-- MailActivation : WORKGROUP_WARN_NEW_MEMBER
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (267, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (268, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (269, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable)  
 	VALUES(29, false, 'WORKGROUP_WARN_NEW_MEMBER', 267, 268, 269, 1, true);

-- MailActivation : WORKGROUP_WARN_UPDATED_MEMBER
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (270, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (271, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (272, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable) 
 	VALUES(30, false, 'WORKGROUP_WARN_UPDATED_MEMBER', 270, 271, 272, 1, true);

-- MailActivation : WORKGROUP_WARN_DELETED_MEMBER
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (273, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (274, true, true, 1, false);
	INSERT INTO policy(id, status, default_status, policy, system)
VALUES (275, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable) 
 	VALUES(31, false, 'WORKGROUP_WARN_DELETED_MEMBER', 273, 274, 275, 1, true);

-- MailActivation : GUEST_WARN_GUEST_ABOUT_HIS_PASSWORD_RESET
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (276, true, true, 0, true);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (277, true, true, 1, false);
INSERT INTO policy(id, status, default_status, policy, system)
	VALUES (278, false, false, 2, true);
INSERT INTO mail_activation(id, system, identifier, policy_activation_id, policy_configuration_id, policy_delegation_id, domain_id, enable) 
 	VALUES(32, false, 'GUEST_WARN_GUEST_ABOUT_HIS_PASSWORD_RESET', 276, 277, 278, 1, true);

