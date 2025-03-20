import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {
        openGroupsPage();
        if(!isGroupPresent()) {
            createGroup("group_name", "group header", "group footer");
        }
        removeGroup();
    }
    
}

