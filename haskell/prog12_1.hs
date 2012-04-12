-- Aufgabe 1)
f :: [Int] -> [Int]
f lst = reverse $ filter (>0) lst

-- Aufgabe 2a)
fh :: Int -> Int -> Int -> Int -> [Int]
fh 4 a b c = [a + b + c]
fh i a b c = this : (fh (i - 1) b c this)
        where this = a + b + c

fl :: Int -> [Int]
fl 1 = [1]
fl 2 = [1, 1]
fl 3 = [1, 1, 1]
fl i = (fl 3) ++ (fh i 1 1 1)

-- Aufgabe 2b)
p :: Int -> Int
p n = last $ fl n

-- alternative Implementierung:
ph :: Int -> Int -> Int -> Int -> Int
ph 4 a b c = a + b + c
ph i a b c = ph (i - 1) b c (a + b + c)

p2 :: Int -> Int
p2 1 = 1
p2 2 = 1
p2 3 = 1
p2 n = ph n 1 1 1

-- Aufgabe 3a)
trans :: [(Int, Int)] -> [Int]
trans lst = map (\(a, b) -> if a > b then a - b else a + b) lst

-- Aufgabe 3b)
liste :: Int -> [Int] -> [Int]
liste a [] = [a]
liste a (x:xs) = if a == x then xs
            else if a < x then a : x : xs
            else x : (liste a xs)
-- Zusatz
max_length :: [[Int]] -> Int
max_length xss = maximum [length xs | xs <- xss]

main = do
    print "Aufgabe 1)"
    print (f [-100..100])
    print "Aufgabe 2a)"
    print (fl 10)
    print "Aufgabe 2b)"
    print (p 10)
    print (p2 10)
    print "Aufgabe 3a)"
    print (trans [(1, 2), (1, 1), (2, 1)])
    print "Aufgabe 3b)"
    print (liste 1 [1..3])
    print (liste 2 [1..3])
    print (liste 0 [1..3])
    print (liste 4 [1..3])
    print "Zusatz"
    print (max_length [[], [1, 3], []])
