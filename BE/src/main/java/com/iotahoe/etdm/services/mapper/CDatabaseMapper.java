package com.iotahoe.etdm.services.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

import com.iotahoe.etdm.entities.CDatabase;
import com.iotahoe.etdm.services.IDatabaseReq;
import com.iotahoe.etdm.services.reqresp.*;

@Mapper
public interface CDatabaseMapper {
    CDatabaseMapper INSTANCE = Mappers.getMapper(CDatabaseMapper.class);

    // , @Mapping(target = "lastAvailable", source = "lastAvailable") , dateFormat =
    // "dd.MM.yyyy hh:dd"
    @Mappings({ @Mapping(target = "type", source = "databaseType.type") })

    CDatabaseResp toResp(CDatabase database);

    CDatabase toEntity(IDatabaseReq req);

    List<CDatabaseResp> toResps(List<CDatabase> list);

}