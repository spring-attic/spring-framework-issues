/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.issues.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/team-technicians")
public class TeamTechnicianController {

	private static Logger logger = LoggerFactory.getLogger(TeamTechnicianController.class);


	@RequestMapping(params = {"technicianId", "teamId"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> findByTeamAndTechnician(
			@RequestParam(value = "teamId", required = true) Long teamId,
			@RequestParam(value = "technicianId", required = true) Long technicianId,
			UriComponentsBuilder builder) {

		return new ResponseEntity<String>("teamId:" + teamId + ", technicianId=" + technicianId, HttpStatus.OK);
	}

	@RequestMapping(params = "technicianId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> findByTechnician(
			@RequestParam(value = "technicianId", required = true) Long technicianId,
			UriComponentsBuilder builder) {

		return new ResponseEntity<String>("technicianId=" + technicianId, HttpStatus.OK);
	}

	@RequestMapping(params = "teamId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> findByTeam(
			@RequestParam(value = "teamId", required = true) Long teamId,
			UriComponentsBuilder builder) {

		return new ResponseEntity<String>("teamId:" + teamId, HttpStatus.OK);
	}

}