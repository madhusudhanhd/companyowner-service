/*
 * package com.danskeinterview.companyowner.entity.mapper;
 * 
 * import java.util.List;
 * 
 * import javax.annotation.Generated;
 * 
 * import com.danskeinterview.companyowner.entity.Company; import
 * com.danskeinterview.companyowner.entity.Owner; import
 * com.danskeinterview.companyowner.entity.model.CompanyDto; import
 * com.danskeinterview.companyowner.entity.model.OwnerDto;
 * 
 * public class EntityModelMapperImpl implements EntityModelMapper{
 * 
 * @Override public Owner convertToEntity(OwnerDto dto) { // TODO Auto-generated
 * method stub return super; }
 * 
 * @Override public OwnerDto convertToDto(Owner entity) { // TODO Auto-generated
 * method stub return null; }
 * 
 * @Override public OwnerDto convertToDto(Owner entity, List<String>
 * activeRoles) { if(entity == null) { return null; }
 * 
 * OwnerDto dto = new OwnerDto(); if (activeRoles.contains("ROLE_ADMIN")) {
 * dto.setName(entity.getName());
 * dto.setSocialSecurityNumber(entity.getSocialSecurityNumber()); }else {
 * dto.setName(entity.getName()); }
 * 
 * return dto; }
 * 
 * @Override public CompanyDto convertToDto(Company entity) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public Company convertToEntity(CompanyDto dto) { // TODO
 * Auto-generated method stub return null; }
 * 
 * }
 */