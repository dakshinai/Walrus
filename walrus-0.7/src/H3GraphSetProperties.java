// 
// The Walrus Graph Visualization Tool.
// Copyright (C) 2000,2001,2002 The Regents of the University of California.
// 
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
// 
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
// 
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
// 
// ######END_HEADER######
// 

import java.util.HashMap;
import java.util.Properties;

//This class helps in reading configuration file that holds setting values for drill down graphs relationships and static loading of graphs
public class H3GraphSetProperties {

    String[] graphPaths;
    int[] graphMainAttributeOrders;
    String[] childGraphNames;
    HashMap<String, Integer> graphMap;
    Properties graphSetProperties;
    int maxPropertyOrder = 3;

    public H3GraphSetProperties(Properties graphSetProperties) throws Exception {
        this.graphSetProperties = graphSetProperties;

        graphPaths = new String[graphSetProperties.size()];

        graphMap = new HashMap<String, Integer>(graphSetProperties.size());

        graphMainAttributeOrders = new int[graphSetProperties.size()];

        childGraphNames = new String[graphSetProperties.size()];

        int count = 0;

        try {

            for (Object key : graphSetProperties.keySet()) {
                String graphAllPropertyValue = (String) graphSetProperties.get(key);
                Object[] graphPropertyArray = graphAllPropertyValue.split(",");

                if (graphPropertyArray.length != maxPropertyOrder) {
                    throw new Exception("Invalid Graph Configuration found for Graph or Child graph");
                } else {

                    graphMap.put((String) key, count);

                    graphPaths[count] = (String) graphPropertyArray[0];
                    childGraphNames[count] = (String) graphPropertyArray[1];
                    graphMainAttributeOrders[count] = Integer.parseInt((String) graphPropertyArray[2]);
                    count++;
                }


            }
        } catch (Exception e) {
            throw new Exception("Invalid Graph Configuration found for Graph or Child graph");
        }
    }

    public String getGraphPath(String graphName) {

        if (graphMap.containsKey(graphName)) {
            if (graphMap.get(graphName) >= 0 && graphMap.get(graphName) < graphPaths.length) {
                return graphPaths[graphMap.get(graphName)];
            }
        }
        return "";
    }

    public int getGraphMainAttributeOrder(String graphName) {

        if (graphMap.containsKey(graphName)) {
            if (graphMap.get(graphName) >= 0 && graphMap.get(graphName) < graphMainAttributeOrders.length) {
                return graphMainAttributeOrders[graphMap.get(graphName)];
            }
        }
        return -1;
    }

    public String[] getGraphNames() {
        String[] graphNames = new String[graphMap.size()];
        graphMap.keySet().toArray(graphNames);
        return graphNames;
    }

    public String getChildGraphName(String graphName) {
        if (graphMap.containsKey(graphName)) {
            if (graphMap.get(graphName) >= 0 && graphMap.get(graphName) < childGraphNames.length) {
                return childGraphNames[graphMap.get(graphName)];
            }
        }
        return "";
    }
}
