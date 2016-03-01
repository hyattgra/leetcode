public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            List<String> arrivals = map.get(ticket[0]);
            if (arrivals == null) {
                arrivals = new ArrayList<>();
                map.put(ticket[0], arrivals);
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        for (List<String> arrivals : map.values()) {
            Collections.sort(arrivals);
        }

        List<String> ret = new ArrayList<>();
        canReach("JFK", map, ret, tickets.length+1);
        return ret;
    }

    private boolean canReach(String stop, Map<String, List<String>> map, List<String> ret, int stops) {
        ret.add(stop);
        if (ret.size() >= stops) {
            return true;
        }

        if(!map.containsKey(stop) || map.get(stop).isEmpty()){
            return false;
        }

        List<String> arrivals = map.get(stop);
        for(int i=0;i<arrivals.size();i++){
            String arr = map.get(stop).remove(i);
            if(canReach(arr, map, ret, stops)){
                return true;
            }
            ret.remove(ret.size()-1);
            map.get(stop).add(i, arr);
        }
        return false;
    }
