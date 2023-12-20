package us.core.pr.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import us.core.pr.controller.abstraction.IPController;
import us.core.pr.domain.entity.Professor;
import us.core.pr.service.abstraction.IPService;

import java.io.Serializable;

@RestController
@RequestMapping(path = "api/v1/professor")
public class ProfessorController
{
}
