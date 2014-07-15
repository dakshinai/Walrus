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


//This class is used to persist the state of a labelled node. It is kept outside H3Graph on purpose as the feature is independent of core libraries
public class H3LabelNode {

    private int _node;
    private boolean areImmediateChildrenLabeled = false;
    private boolean _isLabeled = false;

    public void setIsLabelled(boolean value) {
        this._isLabeled = value;

    }

    public void setAreImmediateChildrenLabeled(boolean value) {

        this.areImmediateChildrenLabeled = value;

    }

    public int getNode() {
        return this._node;
    }

    public boolean getIsLabelled() {
        return this._isLabeled;
    }

    public boolean getAreImmediateChildrenLabeled() {
        return this.areImmediateChildrenLabeled;
    }

    H3LabelNode(int node, boolean areImmediateChildrenLabeled) {


        this._node = node;
        this.areImmediateChildrenLabeled = areImmediateChildrenLabeled;


    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H3LabelNode)) {
            return false;
        }
        H3LabelNode compareNode = (H3LabelNode) obj;
        return _node == compareNode.getNode();


    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this._node;
        return hash;
    }
}
