package com.iotahoe.etdm.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

import com.iotahoe.etdm.entities.CDatabase;
import com.iotahoe.etdm.reqresp.CDatabaseResponse;
import com.iotahoe.etdm.reqresp.DatabaseRequest;

@Mapper
public interface CDatabaseMapper {
    CDatabaseMapper INSTANCE = Mappers.getMapper(CDatabaseMapper.class);

    // , @Mapping(target = "lastAvailable", source = "lastAvailable") , dateFormat =
    // "dd.MM.yyyy hh:dd"
    @Mappings({ @Mapping(target = "type", source = "databaseType.type") })

    CDatabaseResponse toResp(CDatabase database);

    CDatabase toEntity(DatabaseRequest req);

    List<CDatabaseResponse> toResps(List<CDatabase> list);

}