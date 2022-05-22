package edu.sustech.search.engine.github.models;

public interface AppendableResult{

    /**
     * Notice that the <code>null</code> condition needs to be considered
     * @param other other appendable result
     * @return item count appended
     */
    int appendItems(AppendableResult other);

    int getItemCount();
}
