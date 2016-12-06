/**
     * bruteforce solution to bin packing problem.
     *
     * @param in list of items to be packed
     * @param currentPosition position in input list
     */
    private void bruteforce(List<Integer> in, int currentPosition) {
        if (currentPosition >= in.size()) { // reached last item, done with this iteration
            int filledBins = getFilledBinsCount();
            if (filledBins < currentBestSolution) { // is this solution better than the current best?
                currentBestSolution = filledBins; // then save it
                currentBestBins = deepCopy(bins);
            }
            return;
        }
        // iterate over bins
        Integer currentItem = in.get(currentPosition);
        for (Bin bin : bins) {
            if (bin.put(currentItem)) {
                bruteforce(in, currentPosition + 1);
                bin.remove(currentItem);
            } // else: item did not fit in bin, ignore
        }
    }