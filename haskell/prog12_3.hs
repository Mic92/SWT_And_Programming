import Prelude hiding (even)

-- Aufgabe 1
data Tree1 = Node Int [Tree1]
noLeaves :: Tree1 -> Int
noLeaves (Node _ []) = 1
noLeaves (Node _ xs) = noLeavesL xs

noLeavesL :: [Tree1] -> Int
noLeavesL [] = 0
noLeavesL (t:trees) = noLeaves t + noLeavesL trees

even :: Tree1 -> Bool
even (Node _ []) = True
even (Node _ l ) = ((length l) `mod` 2 == 0) && evenL l

evenL :: [Tree1] -> Bool
evenL [] = True
evenL (n:nodes) = even n && evenL nodes

-- Aufgabe 2
data Tree2 a = Branch2 (Tree2 a) (Tree2 a) | Leaf2 a deriving(Show)
check :: Tree2 Bool -> Bool
check (Leaf2 b) = not b
check (Branch2 t1 t2) = check t1 || check t2

toList :: (Tree2 Int) -> [Int]
toList (Leaf2 i) = [i]
toList (Branch2 t1 t2) = toList t2 ++ toList t1

toTree :: [Int] -> Tree2 Int
toTree [] = Leaf2 42 -- was wird hier erwartet?
toTree (x:xs) = Branch2 (Branch2 (Leaf2 42) (Leaf2 x)) (toTree xs)

transform :: [Bool] -> [Bool]
transform [] = []
transform (True:xs) = [True, True] ++ transform xs
transform (False:xs) = transform xs

-- Aufgabe 3
data Tree3 t = Branch3 t (Tree3 t) (Tree3 t) | Leaf3 t
liste :: Tree3 t -> [t]
liste (Leaf3 t) = [t]
--liste (Leaf3 t) = [] -- Mit oder ohne Blatt?
liste (Branch3 t b1 b2) = (liste b1) ++ [t] ++ (liste b2)

g :: (t -> t) -> Tree3 t -> Tree3 t
g f (Leaf3 t) = Leaf3 (f t)
g f (Branch3 t b1 b2) = (Branch3 (f t)  (g f b1) (g f b2))

-- Aufgabe 4 - möglicherweise falsch
{-
t1:
(σ
  (σ
    (γ x1)
    x2)
  (γ
    (γ a)))

t2:
(σ
  (σ
    (γ a)
    (γ
      (γ x)))
  (γ x3))

{(y a) -> x3, a -> x1, (γ (γ x)) -> x2}
-}

main = do
    print "Aufgabe 1"
    print $ noLeaves (Node 0 [(Node 0 []), (Node 0 [])]) -- 2
    print $ even (Node 0 [(Node 0 [])]) -- False
    print $ even (Node 0 [(Node 0 []), (Node 0 [])]) -- True
    print "Aufgabe 2"
    print $ check (Branch2 (Leaf2 True) (Leaf2 True)) -- False
    print $ check (Branch2 (Leaf2 True) (Leaf2 False)) -- True
    -- [3, 2, 1]
    print $ toList (Branch2 (Leaf2 1) (Branch2 (Leaf2 2) (Leaf2 3)))
    print $ toTree [1, 2, 3]
    print $ transform [False, True] -- [True, True]
    print "Aufgabe 3"
    -- [3, 2, 4, 1, 5]
    print $ liste (Branch3 1 (Branch3 2 (Leaf3 3) (Leaf3 4)) (Leaf3 5))
    -- True
    print $ map (\n -> 2*n) (liste tree) == liste (g (\n -> 2*n) tree)
  where tree = Branch3 1 (Branch3 2 (Leaf3 3) (Leaf3 4)) (Leaf3 5)
