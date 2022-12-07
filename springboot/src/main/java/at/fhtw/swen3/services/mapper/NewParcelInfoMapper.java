package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.NewParcelInfoEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;

public class NewParcelInfoMapper extends AbstractMapper<NewParcelInfoEntity, NewParcelInfo> {

    @Override
    public NewParcelInfo entityToDto(NewParcelInfoEntity entity) {
        return null;
    }

    @Override
    public NewParcelInfoEntity dtoToEntity(NewParcelInfo o) {
        return null;
    }
}