package app;

/**
 * MathNum Class
 * @author Joshua Lawrinenko
 */
public class MathNum {
	private static int _def_prec = 12;
	private int _val;
	private int _prec;

	/**
	 * Use Integer.MIN_VALUE, static precision
	 */
	public MathNum() {
		_val = Integer.MIN_VALUE;
		_prec = _def_prec;
	}

	/**
	 * Use given number, static precision
	 * @param n number
	 */
	public MathNum(int n) {
		_val = n;
		_prec = _def_prec;
	}

	/**
	 * Use given number, given precision
	 * @param n number
	 * @param p precision
	 */
	public MathNum(int n, int p) {
		_val = n;
		_prec = p;
	}

	/**
	 * Set static precision
	 * @param p precision
	 */
	public static void setDefPrec(int p) {
		_def_prec = p;
	}

	/**
	 * Get number value
	 * @return number
	 */
	public int val() {
		return _val;
	}

	/**
	 * Set number value
	 * @param n number
	 */
	public void setVal(int n) {
		_val = n;
	}

	/**
	 * Set instance precision
	 * @param p precision
	 */
	public void setPrec(int p) {
		_prec = p;
	}

	/**
	 * Compute GCD of two MathNum objects
	 * @param other MathNum object
	 * @return integer value
	 */
	public int gcd(MathNum other) {
		if (this._val == 0) return other._val;
		if (other._val == 0) return this._val;
		if (this._val == other._val) return this._val;
		int a, b, c;
		if (this._val > other._val) {
			a = this._val;
			b = other._val;
		} else {
			a = other._val;
			b = this._val;
		} while (b > 0) {
			c = a % b;
			a = b;
			b = c;
		} return a;
	}

	/**
	 * Compute LCM of two MathNum objects
	 * @param other MathNum object
	 * @return integer value
	 */
	public int lcm(MathNum other) {
		if (this._val > other._val)
			return (this._val / this.gcd(other)) * other._val;
		else
			return (other._val / other.gcd(this)) * this._val;
	}

	/**
	 * Compute square root of number value
	 * @return integer value
	 */
	public double sqrt() {
		double ans = this._val;
		for (int i = 0; i < _prec; i++) {
			ans = 0.5 * (ans + (this._val / ans));
		}
		return ans;
	}

	@Override
	public String toString() {
		return "" + _val;
	}

	@Override
	public boolean equals(Object other) {
		if(this == other) return true;
		if(!(other instanceof MathNum)) return false;
		MathNum temp = (MathNum) other;
		return this._val == temp._val && this._prec == temp._prec;
	}

	@Override
	public MathNum clone() {
		return new MathNum(_val, _prec);
	}
}
