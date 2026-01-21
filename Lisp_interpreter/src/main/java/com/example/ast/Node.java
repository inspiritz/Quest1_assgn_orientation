package com.example.ast;

import com.example.eval.Visitor;

public interface Node {

    <T> T accept (Visitor<T> visitor);
}
