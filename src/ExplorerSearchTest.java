import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ExplorerSearchTest {
    private static final String Set = null;

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

    @Test
    public void testReachableArea_topCornerStart() {
        int[][] island = {
            {0,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,2,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(3, actual);
    }

    @Test
    public void testReachableArea_topRightStart() {
        int[][] island = {
            {1,1,1,3,1,0},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,2,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(3, actual);
    }

    @Test
    public void testReachableArea_bottomLeftStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,2,1},
            {0,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(10, actual);
    }

    @Test
    public void testReachableArea_bottomRightStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,1},
            {2,1,1,2,1,0},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(13, actual);
    }

    @Test
    public void testReachableArea_allUnreachableExceptStart() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,2},
            {2,1,1,2,3,0},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_NoExplorerPresent() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,2},
            {2,1,1,2,3,1},
        };
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            {
                ExplorerSearch.explorerLocation(island);
            }
        );

        assertEquals("No explorer on the island.", exception.getMessage());
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

    @Test
    public void testPossibleMoves_allDirections() {
        int[][] island = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        int[] start = {1, 1};
        
        List<int[]> moves = ExplorerSearch.possibleMoves(island, start);
        Set<String> movesStrings = toSet(moves);
        
        
        assertTrue(movesStrings.contains("0,1"));
        assertTrue(movesStrings.contains("1,0"));
        assertTrue(movesStrings.contains("1,2"));
        assertTrue(movesStrings.contains("2,1"));
    }

        @Test
    public void testPossibleMoves_SurroundedByOcean() {
        int[][] island = {
            {2, 2, 2},
            {2, 0, 2},
            {2, 2, 2}
        };

        int[] start = {1, 1};
        
        List<int[]> moves = ExplorerSearch.possibleMoves(island, start);
        Set<String> movesStrings = toSet(moves);
        
        
        assertTrue(movesStrings.isEmpty());
    }

    @Test
    public void testPossibleMoves_SurroundedByMountains() {
        int[][] island = {
            {3, 3, 3},
            {3, 0, 3},
            {3, 3, 3}
        };

        int[] start = {1, 1};
        
        List<int[]> moves = ExplorerSearch.possibleMoves(island, start);
        Set<String> movesStrings = toSet(moves);
        
        
        assertTrue(movesStrings.isEmpty());
    }

    @Test
    public void testPossibleMoves_SinglePoint() {
        int[][] island = {
            {0}
        };

        int[] start = {0, 0};
        
        List<int[]> moves = ExplorerSearch.possibleMoves(island, start);
        Set<String> movesStrings = toSet(moves);
        
        
        assertTrue(movesStrings.isEmpty());
    }

    @Test
    public void testPossibleMoves_CanGoSouthAndWest() {
        int[][] island = {
            {3, 3, 3},
            {1, 0, 3},
            {3, 1, 3}
        };

        int[] start = {1, 1};
        
        List<int[]> moves = ExplorerSearch.possibleMoves(island, start);
        Set<String> movesStrings = toSet(moves);
        
        assertEquals(movesStrings.size(), 2);
        assertFalse(movesStrings.contains("0,1"));
        assertTrue(movesStrings.contains("1,0"));
        assertFalse(movesStrings.contains("1,2"));
        assertTrue(movesStrings.contains("2,1"));
    }

    @Test
    public void testPossibleMoves_CanNorthAndEast() {
        int[][] island = {
            {3, 1, 1},
            {2, 0, 1},
            {3, 2, 3}
        };

        int[] start = {1, 1};
        
        List<int[]> moves = ExplorerSearch.possibleMoves(island, start);
        Set<String> movesStrings = toSet(moves);
        
        assertEquals(movesStrings.size(), 2);
        assertTrue(movesStrings.contains("0,1"));
        assertFalse(movesStrings.contains("1,0"));
        assertTrue(movesStrings.contains("1,2"));
        assertFalse(movesStrings.contains("2,1"));
    }

    @Test
    public void testPossibleMoves_NoDiagonal() {
        int[][] island = {
            {0, 2},
            {3, 1}
        };

        int[] start = ExplorerSearch.explorerLocation(island);
        
        List<int[]> moves = ExplorerSearch.possibleMoves(island, start);
        Set<String> movesStrings = toSet(moves);
        
        assertTrue(movesStrings.isEmpty());
    }

    // reused this from the in-class assignment
    private Set<String> toSet(List<int[]> moves) {
        Set<String> set = new HashSet<>();
        for (int[] move : moves) {
            set.add(move[0] + "," + move[1]);
        }

        return set;
    }
}
