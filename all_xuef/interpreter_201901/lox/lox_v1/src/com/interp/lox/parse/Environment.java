package com.interp.lox.parse;

import java.util.HashMap;
import java.util.Map;

import com.interp.lox.Token;

public class Environment {
	// store the bindings
	// the same name should refer to the same variable (ignoring scope for now).
	// Using the string ensures all of those tokens refer to the same map key.
	private final Map<String, Object> bindings = new HashMap<>();

	private Environment parent;

	// The no-argument constructor is for the global scope��s environment,
	// which ends the chain.
	Environment() {
		this.parent = null;
	}

	Environment(Environment parent) {
		this.parent = parent;
	}

	Object getAt(int distance, String name) {
		return ancestor(distance).bindings.get(name);
	}

	Environment ancestor(int distance) {
		Environment environment = this;
		for (int i = 0; i < distance; i++) {
			environment = environment.parent;
		}

		return environment;
	}

	void assignAt(int distance, Token name, Object value) {
		ancestor(distance).bindings.put(name.lexeme, value);
	}

	// a new variable is always declared in the current innermost scope.
	public void bind(String var, Object val) {
		// we don��t check to see if it��s already present
		System.out.println("--- bind var: {" + var + ": " + val + " }");
		bindings.put(var, val);
		System.out.println(this); // display the env
	}

	// But variable lookup and assignment work with existing variables and
	// they need to walk the chain to find it.
	public Object lookup(Token name) {
		if (bindings.containsKey(name.lexeme)) {
			return bindings.get(name.lexeme);
		}
		// if parent env is not null, search var in it
		if (parent != null) {
			return parent.lookup(name);
		}
		throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
	}

	void assign(Token name, Object value) {
		System.out.println();
		if (bindings.containsKey(name.lexeme)) {
			bindings.put(name.lexeme, value);
			return;
		}

		if (this.parent != null) {
			parent.assign(name, value);
			return;
		}
		throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
	}

	@Override
	public String toString() {
		if (this.parent == null) {
			return "---{current: " + bindings.toString() + "\n---  { parent: nil}\n" + "---}";
		} else {
			return "---{current: " + bindings.toString() + "\n---  { parent: " + parent.toString() + "}\n" + "---}";
		}
	}
}