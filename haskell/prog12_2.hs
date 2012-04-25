import Data.List hiding(insert)

-- Too simple, right?
compare_ :: [Int] -> [Int] -> Bool
compare_ l1 l2 = l1 == l2 -- was haben die erwartet?


-- keep simple and stupid
merge :: [Int] -> [Int] -> [Int]
merge l1 l2 = sort (l1 ++ l2)

-- ok, hier nochmal so wie das wollen
merge2 :: [Int] -> [Int] -> [Int]
merge2 l1 [] = l1
merge2 [] l2 = l2
merge2 (x1:xs1) (x2:xs2)
    | x1 <= x2  = x1 : merge2 xs1 (x2:xs2)
    | otherwise = x2 : merge2 (x1:xs1) xs2


-- Limitierung: NodeB kann kein Blatt als Nachfolger haben
data NodeB = NodeB Bool BTree BTree | Leaf Int
    deriving (Show) -- für print
data BTree = BTree Int NodeB NodeB
    deriving (Show) -- für print


--  x
-- / \
exampleBTree = BTree 1 (Leaf 1) (Leaf 2)

--   x
--  / \
--    /\
exampleBTree2 = BTree 1
    (Leaf 2)
    (NodeB True
        (BTree 1 (Leaf 2) (Leaf 2))
        (BTree 1 (Leaf 2) (Leaf 2)))


data TA = EmptyA | A Int TA TB
    deriving (Show) -- für print
data TB = EmptyB | B Int TB TA
    deriving (Show) -- für print

exampleTB = B 1
    (B 2
        EmptyB
        (A 3 EmptyA EmptyB))
    EmptyA
exampleTA = A 4 (A 5 EmptyA EmptyB) exampleTB


trans :: TA -> TA
trans tb = transA tb 0

transA :: TA -> Int -> TA
transA EmptyA _ = EmptyA
transA (A _ ta tb) i = A i (transA ta i) (transB tb i)

transB :: TB -> Int -> TB
transB EmptyB _ = EmptyB
transB (B n tb ta) i = B n (transB tb (i+1)) (transA ta (i+1))


list :: TA -> [Int]
list EmptyA = []
list (A i ta tb) = i : (list ta) ++ (listB tb)

listB :: TB -> [Int]
listB EmptyB = []
listB (B _ tb ta) = (listB tb) ++ (list ta)


-- Standardfunktionen selber implementieren. O RLY?
-- Jedes Mal, wenn man das macht, stirbt irgendwo ein Kätzchen.
length2 :: [a] -> Int  -- *tot*
length2 [] = 0
length2 (_:xs) = 1 + length2 xs

map2 :: (a -> b) -> [a] -> [b] -- *tot*
map2 f [] = []
map2 f (x:xs) = f x : map2 f xs

replicate2 :: Int -> a -> [a] -- *tot*
replicate2 n a
    | n < 1     = []
    | otherwise = a : replicate2 (n - 1) a

-- Ganz ehrlich, die Übungsleiter sollten einfach weniger nehmen.
incEntry :: [Int] -> Int -> [Int]
incEntry l i = map2 (+i)
    (l ++ replicate2 (i - length2 l) 0)


rsum :: [Int] -> [Int]
rsum l = rsumh (reverse l) 0

rsumh :: [Int] -> Int -> [Int]
rsumh [] n = []
rsumh (x:xs) n = n2 : rsumh xs (n2)
    where n2 = n + x


data Tree = Node Int Tree Tree | NIL
    deriving (Show)

insert :: Tree -> [Int] -> Tree
insert t [] = t
insert t (x:xs) = insert (inserth t x) xs

inserth :: Tree -> Int -> Tree
inserth NIL i = Node i NIL NIL
inserth (Node val left right) i
    | i < val = Node val (inserth left i) right
    | i > val = Node val left (inserth right i)
    | otherwise = Node val left right


treeEq :: Tree -> Tree -> Bool
treeEq NIL NIL = True
treeEq NIL (Node i2 l2 r2) = False
treeEq (Node i1 l1 r1) NIL = False
treeEq (Node i1 l1 r1) (Node i2 l2 r2)
    = (i1 == i2) && treeEq l1 l2 && treeEq r1 r2


main = do
    print "Aufgabe 1a)"
    print $ compare_ [] []
    print $ compare_ [1, 3] [1]
    print "Aufgabe 1b)"
    print $ merge [] [1, 4, 5]
    print $ merge2 [] [1, 4, 5]
    print $ merge [1, 2] [1, 4, 5]
    print $ merge2 [1, 2] [1, 4, 5]
    print "Aufgabe 1c)"
    print $ exampleBTree
    print $ exampleBTree2
    print "Aufgabe 2a)"
    print $ exampleTB
    print $ exampleTA
    print "Aufgabe 2b)"
    print $ trans exampleTA
    print "Aufgabe 2c)"
    print $ list exampleTA
    print "Aufgabe 3a)"
    print $ incEntry [1, 2, 3, 4] 4
    print $ incEntry [2, 3] 4
    print "Aufgabe 3b)"
    print $ rsum [1, 2, 3, 4]
    print "Aufgabe 4a)"
    print $ insert (Node 1 NIL NIL) [0, 0, 2]
    print "Aufgabe 4b)"
    print $ treeEq (Node 1 NIL NIL) (Node 1 NIL NIL)
    print $ treeEq (Node 1 (Node 1 NIL NIL) NIL) (Node 1 NIL NIL)
    print $ treeEq (Node 1 NIL (Node 1 NIL NIL)) (Node 1 NIL NIL)
