package app;

/**
 * MathNum Class
 * @author Joshua Lawrinenko
 */
public class MathNum {
	private static int _def_prec = 12;
	private long _val;
	private int _prec;
	private java.util.ArrayList<Long> _flist;
	private java.util.ArrayList<Long> _pflist;

	private void setFactorList() {
		for (long i = 1; i * i < _val + 1; i++) {
			if (_val % i == 0) _flist.add(i);
		}
		int lim = _flist.size() - 1;
		for (int i = lim; i >= 0; i--) {
			_flist.add((long) _val / _flist.get(i));
		}
	}

	private void setPrimeFactorList() {
		long temp = _val;
		for (long f : _flist) {
			if (MathNum.isPrime(f)) {
				while (temp % f == 0) { 
					_pflist.add(f);
					temp = temp / f;
				}
			}
		}
	}

	/**
	 * Determines primality of given number
	 * @param x long
	 * @return boolean
	 */
	public static boolean isPrime(long x) {
		if (x <= 1) return false;
		if (x <= 3) return true;
		if (x % 2 == 0) return false;
		for (long i = 5; i * i < x; i += 2) {
			if (x % i == 0) return false;
		}
		return true;
	}

	/**
	 * Set static precision
	 * @param p 0 &lt; p &lt; 10^3
	 */
	public static void setDefPrec(int p) {
		if (p < 1) _def_prec = 1;
		else if (p > 1000) _def_prec = 1000;
		else _def_prec = p;
	}

	/**
	 * Use 1 for number, static precision
	 */
	public MathNum() {
		_val = 1;
		_prec = _def_prec;
		_flist = new java.util.ArrayList<>();
		this.setFactorList();
		_pflist = new java.util.ArrayList<>();
		this.setPrimeFactorList();
	}

	/**
	 * Use given number, static precision
	 * @param n 0 &lt; n &lt; 10^9
	 */
	public MathNum(long n) {
		if (n < 1) _val = 1;
		else if (n > 9_999_999_999L) _val = 9_999_999_999L;
		else _val = n;
		_prec = _def_prec;
		_flist = new java.util.ArrayList<>();
		this.setFactorList();
		_pflist = new java.util.ArrayList<>();
		this.setPrimeFactorList();
	}

	/**
	 * Use given number, given precision
	 * @param n 0 &lt; n &lt; 10^9
	 * @param p 0 &lt; n &lt; 10^3
	 */
	public MathNum(long n, int p) {
		if (n < 1) _val = 1;
		else if (n > 9_999_999_999L) _val = 9_999_999_999L;
		else _val = n;
		if (p < 1) _def_prec = 1;
		else if (p > 1000) _def_prec = 1000;
		else _def_prec = p;
		_flist = new java.util.ArrayList<>();
		this.setFactorList();
		_pflist = new java.util.ArrayList<>();
		this.setPrimeFactorList();
	}

	/**
	 * Get number value
	 * @return long
	 */
	public long getVal() {
		return _val;
	}

	/**
	 * Set number value
	 * @param n 0 &lt; n &lt; 10^9
	 */
	public void setVal(long n) {
		if (n < 1) _val = 1;
		else if (n > 9_999_999_999L) _val = 9_999_999_999L;
		else _val = n;
		_flist.clear();
		this.setFactorList();
		_pflist.clear();
		this.setPrimeFactorList();
	}

	/**
	 * Set instance precision
	 * @param p 0 &lt; p &lt; 10^3
	 */
	public void setPrec(int p) {
		if (p < 1) _prec = 1;
		else if (p > 1000) _prec = 1000;
		else _prec = p;
	}

	/**
	 * String representation of factor list
	 * @return String
	 */
	public String getFactors() {
		String ans = "";
		for (int i = 0; i < _flist.size() - 1; i++) {
			ans += Long.toString(_flist.get(i)) + ", ";
		}
		ans += Long.toString(_flist.get(_flist.size() - 1));
		return ans;
	}

	/**
	 * String representation of prime factor list
	 * @return String
	 */
	public String getPrimeFactors() {
		if (_pflist.size() == 1) return Long.toString(_pflist.get(0));
		String ans = "";
		long fct = _pflist.get(0);
		int mult = 1;
		for (int i = 1; i < _pflist.size() - 1; i++) {
			if (fct != _pflist.get(i)) {
				if (mult > 1) {
					ans += Long.toString(fct) + "^" + Integer.toString(mult) + " * ";
					mult = 1;
				} else {
					ans += Long.toString(fct) + " * ";
				}
				fct = _pflist.get(i);
			} else {
				mult++;
			}
		}
		if (fct == _pflist.get(_pflist.size() - 1)) {
			ans += Long.toString(fct) + "^" + Long.toString(mult + 1);
		} else if (mult > 1) {
			ans += Long.toString(fct) + "^" + Long.toString(mult) + " * " + Long.toString(_pflist.get(_pflist.size() - 1));
		} else {
			ans += Long.toString(fct) + " * " + Long.toString(_pflist.get(_pflist.size() - 1));
		}
		return ans;
	}

	/**
	 * Compute GCD of two MathNum objects
	 * @param other MathNum object
	 * @return long
	 */
	public long gcd(MathNum other) {
		if (this._val == 0) return other._val;
		if (other._val == 0) return this._val;
		if (this._val == other._val) return this._val;
		long a, b, c;
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
	 * @return long
	 */
	public long lcm(MathNum other) {
		if (this._val > other._val)
			return (this._val / this.gcd(other)) * other._val;
		else
			return (other._val / other.gcd(this)) * this._val;
	}

	/**
	 * Compute square root of number value using instance precision
	 * @return double
	 */
	public double sqrt() {
		double ans = this._val / 2.0;
		for (int i = 0; i < _prec; i++) {
			ans = 0.5 * (ans + (this._val / ans));
		}
		return ans;
	}

	/**
	 * Compute square root of number value using given precision
	 * @param p 0 &lt; n &lt; 10^3
	 * @return double
	 */
	public double sqrt(int p) {
		double ans = this._val / 2.0;
		if (p < 1) p = 1;
		else if (p > 1000) p = 1000;
		for (int i = 0; i < p; i++) {
			ans = 0.5 * (ans + (this._val / ans));
		}
		return ans;
	}

	/**
	 * Compute number value to given power
	 * @param x -12 &le; x &le; 12
	 * @return double
	 */
	public double pow(int x) {
		double ans = 1.0;
		if (x == 0) return ans;
		else if (x < -12) x = -12;
		else if (x > 12) x = 12;
		if (x > 0) {
			for (int i = 0; i < x; i++) {
				ans = ans * this._val;
			}
		}
		else if (x < 0) {
			for (int i = x; i < 0; i++) {
				ans = ans * this._val;
			}
			ans = 1.0 / ans;
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
