package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.controller.WarehouseApiController;
import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-25T14:13:18.811165Z[Etc/UTC]")
@Validated
@Tag(name = "warehouse", description = "Operations for the warehouse management.")
@RequestMapping("${openapi.parcelLogisticsService.base-path:}")
public interface WarehouseApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /warehouse : Exports the hierarchy of Warehouse and Truck objects.
     *
     * @return Successful response (status code 200)
     * or The operation failed due to an error. (status code 400)
     * or No hierarchy loaded yet. (status code 404)
     */
    @Operation(
            operationId = "exportWarehouses",
            summary = "Exports the hierarchy of Warehouse and Truck objects. ",
            tags = {"warehouse-management"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Warehouse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "No hierarchy loaded yet.")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/warehouse",
            produces = {"application/json"}
    )
    ResponseEntity<Warehouse> exportWarehouses();


    /**
     * GET /warehouse/{code} : Get a certain warehouse or truck by code
     *
     * @param code (required)
     * @return Successful response (status code 200)
     * or The operation failed due to an error. (status code 400)
     * or No hop with the specified id could be found. (status code 404)
     */
    @Operation(
            operationId = "getWarehouse",
            summary = "Get a certain warehouse or truck by code",
            tags = {"warehouse-management"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Hop.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "No hop with the specified id could be found.")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/warehouse/{code}",
            produces = {"application/json"}
    )
    ResponseEntity<Hop> getWarehouse(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("code") String code);


    /**
     * POST /warehouse : Imports a hierarchy of Warehouse and Truck objects.
     *
     * @param warehouse (required)
     * @return Successfully loaded. (status code 200)
     * or The operation failed due to an error. (status code 400)
     */
    @Operation(
            operationId = "importWarehouses",
            summary = "Imports a hierarchy of Warehouse and Truck objects. ",
            tags = {"warehouse-management"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully loaded."),
                    @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/warehouse",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    ResponseEntity<Void> importWarehouses(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Warehouse body);

}
