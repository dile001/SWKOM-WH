package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import at.fhtw.swen3.persistence.entities.ErrorEntity.ErrorEntityBuilder;
import at.fhtw.swen3.services.dto.Error;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T18:58:48+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class ErrorMapperImpl implements ErrorMapper {

    @Override
    public Error entityToDto(ErrorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Error error = new Error();

        error.setErrorMessage( entity.getErrorMessage() );

        return error;
    }

    @Override
    public ErrorEntity dtoToEntity(Error o) {
        if ( o == null ) {
            return null;
        }

        ErrorEntityBuilder errorEntity = ErrorEntity.builder();

        errorEntity.errorMessage( o.getErrorMessage() );

        return errorEntity.build();
    }
}
