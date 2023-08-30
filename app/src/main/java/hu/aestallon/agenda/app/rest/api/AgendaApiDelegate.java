package hu.aestallon.agenda.app.rest.api;

import hu.aestallon.agenda.app.rest.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link AgendaApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface AgendaApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /agenda : Create a new item in the agenda.
     * ...
     *
     * @param task  (required)
     * @return Ok (status code 200)
     * @see AgendaApi#createTask
     */
    default ResponseEntity<List<Task>> createTask(Task task) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"important\" : false, \"description\" : \"Washing the dishes is very important!\", \"id\" : 1024, \"completed\" : false, \"title\" : \"Wash the dishes\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /agenda/{id} : Delete a task in the agenda
     * ...
     *
     * @param id  (required)
     * @return Ok (status code 200)
     *         or Unknown task (status code 404)
     * @see AgendaApi#deleteTask
     */
    default ResponseEntity<Void> deleteTask(Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /agenda : List all items in the agenda.
     * ...
     *
     * @return Ok (status code 200)
     * @see AgendaApi#getAllTasks
     */
    default ResponseEntity<List<Task>> getAllTasks() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"important\" : false, \"description\" : \"Washing the dishes is very important!\", \"id\" : 1024, \"completed\" : false, \"title\" : \"Wash the dishes\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /agenda/{id} : Update a task in the agenda
     * ...
     *
     * @param id  (required)
     * @param task  (required)
     * @return Ok (status code 200)
     *         or Unknown task (status code 404)
     * @see AgendaApi#updateTask
     */
    default ResponseEntity<List<Task>> updateTask(Long id,
        Task task) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"important\" : false, \"description\" : \"Washing the dishes is very important!\", \"id\" : 1024, \"completed\" : false, \"title\" : \"Wash the dishes\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
