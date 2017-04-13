// Brittni Watkins
// 15 March 2017
// Project Solution: Dynamic Artwork
// DimVector Class
// Dimension Vector

public class DimVector {
    public float w;
    public float h;

    public DimVector() {
        w = 0;
        h = 0;
    }

    public DimVector(DimVector v) {
        w = v.w;
        h = v.h;
    }

    public DimVector(float w, float h) {
        this.w = w;
        this.h = h;
    }

    public void set(float w, float h) {
        this.w = w;
        this.h = h;
    }

    public void set(DimVector v) {
        w = v.w;
        h = v.h;
    }

}
