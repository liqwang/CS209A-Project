package edu.sustech.search.engine.github.models;

public interface AppendableResult {

    /**
     *
     * @param other other appendable result
     * @return item count appended
     */
    public int appendItems(AppendableResult other);

    public int getItemCount();
}
