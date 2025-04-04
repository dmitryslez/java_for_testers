package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("", "name", "group header", "group footer"));
        }
        var oldGropus = app.groups().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGropus.size());
        app.groups().removeGroup(oldGropus.get(index));
        var newGropus = app.groups().getList();
        var expectedList = new ArrayList<>(oldGropus);
        expectedList.remove(index);
        Assertions.assertEquals(newGropus,expectedList);
    }

    @Test
    void canRemoveAllGroupsAtOnce() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("", "name", "group header", "group footer"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.groups().getCount());
    }

}

