/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package hu.aestallon.agenda.app.rest.api;

import hu.aestallon.agenda.app.rest.model.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "agenda", description = "To-Do list related operations")
public interface AgendaApi {

    default AgendaApiDelegate getDelegate() {
        return new AgendaApiDelegate() {};
    }

    /**
     * POST /agenda : Create a new item in the agenda.
     * ...
     *
     * @param task  (required)
     * @return Ok (status code 200)
     */
    @Operation(
        operationId = "createTask",
        summary = "Create a new item in the agenda.",
        tags = { "Agenda" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Ok", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/agenda",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Task> createTask(
        @Parameter(name = "Task", description = "", required = true) @Valid @RequestBody Task task
    ) {
        return getDelegate().createTask(task);
    }


    /**
     * DELETE /agenda/{id} : Delete a task in the agenda
     * ...
     *
     * @param id  (required)
     * @return Ok (status code 200)
     *         or Unknown task (status code 404)
     */
    @Operation(
        operationId = "deleteTask",
        summary = "Delete a task in the agenda",
        tags = { "Agenda" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Unknown task")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/agenda/{id}"
    )
    default ResponseEntity<Void> deleteTask(
        @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id
    ) {
        return getDelegate().deleteTask(id);
    }


    /**
     * GET /agenda : List all items in the agenda.
     * ...
     *
     * @return Ok (status code 200)
     */
    @Operation(
        operationId = "getAllTasks",
        summary = "List all items in the agenda.",
        tags = { "Agenda" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Ok", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/agenda",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Task>> getAllTasks(
        
    ) {
        return getDelegate().getAllTasks();
    }


    /**
     * PUT /agenda/{id} : Update a task in the agenda
     * ...
     *
     * @param id  (required)
     * @param task  (required)
     * @return Ok (status code 200)
     *         or Unknown task (status code 404)
     */
    @Operation(
        operationId = "updateTask",
        summary = "Update a task in the agenda",
        tags = { "Agenda" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Ok", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Task.class))
            }),
            @ApiResponse(responseCode = "404", description = "Unknown task")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/agenda/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Task> updateTask(
        @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id,
        @Parameter(name = "Task", description = "", required = true) @Valid @RequestBody Task task
    ) {
        return getDelegate().updateTask(id, task);
    }

}
