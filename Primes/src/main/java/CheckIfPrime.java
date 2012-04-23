class CheckIfPrime {
        private int nums[];
        CheckIfPrime(int numberArray[]) {
                nums = numberArray;
        }
        boolean checkIfSingleNumberIsPrime(int num) {
                int max = (int) Math.ceil(Math.sqrt(num));
                if (num <= 1) {
                    return false;
                }
                if (num == 2) {
                    return true;
                }
                for (int i = 2; i <= max; i++) {
                    if ((num % i) == 0) {
                        return false;
                    }
                }
                return true;
        }
        String[] checkIfNumbersInArrayArePrime() {
            int len = nums.length;
            String[] res = new String[len];
            for (int i = 0; i < len; i++) {
                boolean isPrime = checkIfSingleNumberIsPrime(nums[i]);
                res[i] = String.format("%d: %b", nums[i], isPrime);
            }
            return res;
        }
}
