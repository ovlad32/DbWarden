package com.iotahoe.etdm.services.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

import com.iotahoe.etdm.entities.CDatabase;
import com.iotahoe.etdm.services.reqresp.*;

@Mapper
public interface CDatabaseMapper {
    CDatabaseMapper INSTANCE = Mappers.getMapper(CDatabaseMapper.class);

    @Mappings({ @Mapping(source = "databaseType.type", target = "type") })

    CDatabaseResp toResp(CDatabase database);

    List<CDatabaseResp> toResps(List<CDatabase> list);

}