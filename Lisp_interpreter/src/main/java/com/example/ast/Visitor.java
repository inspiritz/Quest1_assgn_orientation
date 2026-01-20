package com.example.ast;

public interface Visitor<T> {
    T visitNumber(NumberNode node);
    T visitSymbol (SymbolNode node);
    T visitList (ListNode node);
}
