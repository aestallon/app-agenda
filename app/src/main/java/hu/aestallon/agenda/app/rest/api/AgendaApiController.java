package hu.aestallon.agenda.app.rest.api;

import hu.aestallon.agenda.app.rest.model.Task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Controller
@RequestMapping("${openapi.agenda.base-path:}")
public class AgendaApiController implements AgendaApi {

    private final AgendaApiDelegate delegate;

    public AgendaApiController(@Autowired(required = false) AgendaApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new AgendaApiDelegate() {});
    }

    @Override
    public AgendaApiDelegate getDelegate() {
        return delegate;
    }

}
