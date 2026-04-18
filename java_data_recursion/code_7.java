public static List<String> letterCasePermutation(String S) {
        List<Integer> positions = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < S.length(); i++){
            if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')){
                positions.add(i);
                characters.add(S.charAt(i));
            }
        }
        List<String> result = new ArrayList<>();
        char[] currentLeaf = new char[S.length()];
        for (int i = 0; i < S.length(); i++){
            if (!(S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')){
                currentLeaf[i] = S.charAt(i);
            }
        }
        recursion(positions, characters, currentLeaf, result, positions.size() - 1);
        return result;
    }

    public static void recursion(List<Integer> letterIndex, List<Character> characters, char[] currentLeaf, List<String> result, int index){
        if (index == -1){
            result.add(String.valueOf(currentLeaf));
        }
        else {
            for (int i = 0; i < 2; i++){
                char mainn = characters.get(index);
                char main1, main2;
                if (mainn >= 'a' && mainn <= 'z'){
                    main1 = mainn;
                    main2 = (char)(mainn - 32);
                }
                else {
                    main2 = mainn;
                    main1 = (char)(mainn + 32);
                }
                if (i == 0){
                    currentLeaf[letterIndex.get(index)] = main1;
                }
                else {
                    currentLeaf[letterIndex.get(index)] = main2;
                }
                recursion(letterIndex, characters, currentLeaf, result, index-1);
            }
        }
    }