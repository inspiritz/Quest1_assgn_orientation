package com.example.eval;

import com.example.ast.ListNode;
import com.example.ast.NumberNode;
import com.example.ast.SymbolNode;

public interface Visitor<T> {
    T visitNumber(NumberNode node);
    T visitSymbol (SymbolNode node);
    T visitList (ListNode node);
}
