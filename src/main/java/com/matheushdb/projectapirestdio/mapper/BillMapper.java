package com.matheushdb.projectapirestdio.mapper;

import com.matheushdb.projectapirestdio.dto.request.BillDTO;
import com.matheushdb.projectapirestdio.entity.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillMapper {

    BillMapper INSTANCE = Mappers.getMapper(BillMapper.class);

    Bill toModel(BillDTO billDTO);

    BillDTO toDTO(Bill bill);

}
