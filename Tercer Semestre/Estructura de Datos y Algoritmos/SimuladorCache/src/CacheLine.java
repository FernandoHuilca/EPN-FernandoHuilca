class CacheLine {
    boolean valid;
    int tag;
    int data;

    public CacheLine() {
        this.valid = false;
        this.tag = -1;
        this.data = 0;
    }
}