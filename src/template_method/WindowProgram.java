abstract class WindowProgram {

    abstract protected void drawMain();
    abstract protected String getTitle();

    void draw() {
        drawTitle(getTitle());
        drawToolbar();
        drawMain();
        drawFooter();
    }

    private void drawTitle(String title) {
        System.out.println("===============================================");
        System.out.println("ㅁ" + title);
        System.out.println("===============================================");
    }

    private void drawToolbar() {
        System.out.println("File | Edit | View | Navigate");
        System.out.println("===============================================");
    }

    private void drawFooter() {
        System.out.println("===============================================");
    }
}

