package stepic.t7s1;

interface Editor {

    /**
     * Select all text.
     */
    void selectAll();

    /**
     * Returns previously selected text.
     */
    String getSelection();

    /**
     * Replaces selected text with the specified value.
     *
     * @param value the text that replaces selected text
     */
    void replaceSelection(String value);

    /**
     * Returns text in the clipboard.
     */
    String getClipboard();

    /**
     * Saves provided value to the clipboard.
     *
     * @param value the text that will be saved to the clipboard
     */
    void saveToClipboard(String value);
}
