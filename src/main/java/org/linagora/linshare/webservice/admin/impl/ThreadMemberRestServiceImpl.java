/*
 * LinShare is an open source filesharing software, part of the LinPKI software
 * suite, developed by Linagora.
 * 
 * Copyright (C) 2015-2018 LINAGORA
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version, provided you comply with the Additional Terms applicable for
 * LinShare software by Linagora pursuant to Section 7 of the GNU Affero General
 * Public License, subsections (b), (c), and (e), pursuant to which you must
 * notably (i) retain the display of the “LinShare™” trademark/logo at the top
 * of the interface window, the display of the “You are using the Open Source
 * and free version of LinShare™, powered by Linagora © 2009–2018. Contribute to
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

package org.linagora.linshare.webservice.admin.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.linagora.linshare.core.exception.BusinessException;
import org.linagora.linshare.core.facade.webservice.admin.ThreadMemberFacade;
import org.linagora.linshare.core.facade.webservice.common.dto.WorkGroupMemberDto;
import org.linagora.linshare.webservice.admin.ThreadMemberRestService;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/thread_members")
@Api(value = "/rest/admin/thread_members", description = "Thread members service")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class ThreadMemberRestServiceImpl implements ThreadMemberRestService {

	private final ThreadMemberFacade threadMemberFacade;

	public ThreadMemberRestServiceImpl(
			final ThreadMemberFacade threadMemberFacade) {
		super();
		this.threadMemberFacade = threadMemberFacade;
	}

	@Path("/{id}")
	@GET
	@ApiOperation(value = "Find a thread member.", response = WorkGroupMemberDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "User isn't admin.") })
	@Override
	public WorkGroupMemberDto find(@PathParam("id") Long id)
			throws BusinessException {
		return threadMemberFacade.find(id);
	}

	@Path("/{id}")
	@HEAD
	@ApiOperation(value = "Find a thread member.")
	@ApiResponses({ @ApiResponse(code = 403, message = "User isn't admin.") })
	@Override
	public void head(@PathParam("id") Long id)
			throws BusinessException {
		threadMemberFacade.find(id);
	}


	@Path("/")
	@POST
	@ApiOperation(value = "Create a thread member.", response = WorkGroupMemberDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "User isn't admin.") })
	@Override
	public WorkGroupMemberDto create(WorkGroupMemberDto dto) throws BusinessException {
		return threadMemberFacade.create(dto);
	}

	@Path("/")
	@PUT
	@ApiOperation(value = "Update a thread member.", response = WorkGroupMemberDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "User isn't admin.") })
	@Override
	public WorkGroupMemberDto update(WorkGroupMemberDto dto) throws BusinessException {
		return threadMemberFacade.update(dto);
	}

	@Path("/")
	@DELETE
	@ApiOperation(value = "Delete a thread member.", response = WorkGroupMemberDto.class)
	@ApiResponses({ @ApiResponse(code = 403, message = "User isn't admin.") })
	@Override
	public WorkGroupMemberDto delete(WorkGroupMemberDto dto) throws BusinessException {
		WorkGroupMemberDto ret = threadMemberFacade.delete(dto);
		return ret;
	}
}
