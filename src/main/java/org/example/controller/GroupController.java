package org.example.controller;

import org.example.entities.Group.Group;
import org.example.entities.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groupList;

    public GroupController() {
        groupList = new ArrayList<>();
    }

    public void createGroup(String groupId, String groupName, User createByUser) {
        Group newGroup = new Group();
        newGroup.setGroupId(groupId);
        newGroup.setGroupName(groupName);
        newGroup.addMember(createByUser);

        groupList.add(newGroup);
    }

    public Group getGroup(String groupId){
        for(Group group: groupList) {
            if(group.getGroupId().equals(groupId)){
                return group;
            }
        }
        return null;
    }

}
