import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases
    @Test public void testExplorerLocation_topLeftCorner() {
        int[][] island = {
            {0,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };

        int[] expected = {0, 0};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

        @Test public void testExplorerLocation_topRightCorner() {
        int[][] island = {
            {1,1,1,3,1,0},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };

        int[] expected = {0, 5};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

        @Test public void testExplorerLocation_bottomLeftCorner() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {0,1,1,2,1,1},
        };

        int[] expected = {4, 0};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

        @Test public void testExplorerLocation_bottomRightCorner() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,0},
        };

        int[] expected = {4, 5};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test public void testExplorerLocation_middle() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,0,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };

        int[] expected = {2, 3};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

        @Test public void testExplorerLocation_middleRight() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,0},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };

        int[] expected = {2, 5};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test public void testExplorerLocation_singleElement() {
        int[][] island = {
            {0}
        };

        int[] expected = {0, 0};
        assertArrayEquals(expected, ExplorerSearch.explorerLocation(island));
    }

    @Test public void testExplorerLocation_noExplorer() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {1,1,1,2,1,1},
        };

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ExplorerSearch.explorerLocation(island);
        });

        assertEquals("No explorer on the island.", exception.getMessage());
    }
}
