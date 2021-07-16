package com.stream.java8;

import com.entity.RoleDataDTO;
import com.entity.RoleDataUserGroupDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xiazhongwei
 * @Date: 2021/7/16 16:27
 */
public class FlatMapAPI {

    /**
     * List  嵌套 List ,将最终结果合并到一个List并去重
     * @param args
     */
    public static void main(String[] args) {
        List<RoleDataUserGroupDTO> roleDataUserGroupDTOS = new ArrayList<>();
        List<RoleDataDTO> roleDataDTOS = new ArrayList<>();
        RoleDataDTO dataDTO = new RoleDataDTO();
        dataDTO.setDataId(1L);
        RoleDataDTO dataDTO2 = new RoleDataDTO();
        dataDTO2.setDataId(2L);
        RoleDataDTO dataDTO3 = new RoleDataDTO();
        dataDTO3.setDataId(3L);
        RoleDataDTO dataDTO4 = new RoleDataDTO();
        dataDTO4.setDataId(4L);
        roleDataDTOS.add(dataDTO);
        roleDataDTOS.add(dataDTO2);
        roleDataDTOS.add(dataDTO3);
        roleDataDTOS.add(dataDTO4);
        RoleDataUserGroupDTO roleDataUserGroupDTO = new RoleDataUserGroupDTO();
        roleDataUserGroupDTO.setRoleDataDTOS(roleDataDTOS);


        List<RoleDataDTO> roleDataDTOS2 = new ArrayList<>();
        RoleDataDTO dataDTO11 = new RoleDataDTO();
        dataDTO11.setDataId(11L);
        RoleDataDTO dataDTO22 = new RoleDataDTO();
        dataDTO22.setDataId(22L);
        RoleDataDTO dataDTO33 = new RoleDataDTO();
        dataDTO33.setDataId(33L);
        RoleDataDTO dataDTO44 = new RoleDataDTO();
        dataDTO44.setDataId(44L);
        roleDataDTOS2.add(dataDTO11);
        roleDataDTOS2.add(dataDTO22);
        roleDataDTOS2.add(dataDTO33);
        roleDataDTOS2.add(dataDTO44);

        RoleDataUserGroupDTO roleDataUserGroupDTO2 = new RoleDataUserGroupDTO();
        roleDataUserGroupDTO2.setRoleDataDTOS(roleDataDTOS2);
        roleDataUserGroupDTOS.add(roleDataUserGroupDTO);
        roleDataUserGroupDTOS.add(roleDataUserGroupDTO2);

        List<Long> collect = roleDataUserGroupDTOS.stream()
                .map(RoleDataUserGroupDTO::getRoleDataDTOS)
                .flatMap(Collection::stream).map(RoleDataDTO::getDataId)
                .distinct().collect(Collectors.toList());
        System.out.println(collect);


    }
}
