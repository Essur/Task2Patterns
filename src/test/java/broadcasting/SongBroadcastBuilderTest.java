package broadcasting;

import org.junit.jupiter.api.*;
import presenter.LeadHost;
import presenter.MainLeadHost;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SongBroadcastBuilderTest {
    private BroadcastBuilder broadcastBuilder;
    private LeadHost mainLeadHost;

    @BeforeEach
    void setUp() {
        broadcastBuilder = new SongBroadcastBuilder();
        mainLeadHost = new MainLeadHost(broadcastBuilder, "Oleg", "2 years");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void createBroadcastTooMuchPaid() {
        assertNull(mainLeadHost.createBroadcast("IsNotCreated","Cause too much paid content",
                1500,"Test", 60,"Test", 1840, "Test1"));
    }
    @Test
    @Order(2)
    void createBroadcastTooBigBroadcast() {
        assertNull(mainLeadHost.createBroadcast("IsNotCreated","Cause too big broadcast",
                3800,"Test2", 60,"Test2", 740, "Test2"));
    }
    @Test
    @Order(3)
    void createBroadcastTooMuchAdvertisement() {
        assertNull(mainLeadHost.createBroadcast("IsNotCreated","Cause too much advertisement",
                1800,"Test3", 960,"Test3", 740, "Test3"));
    }
    @Test
    @Order(4)
    void createBroadcast() {
        Broadcast broadcast = mainLeadHost.createBroadcast("Created","Broadcast was created!",
                1800,"Test4", 60,"Test4", 740, "Test4");
        assertNotNull(broadcast);
        System.out.println("Object was created " + broadcast);
    }
}