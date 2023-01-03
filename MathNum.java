package app;

public class MathNum {
    private static int _def_prec = 12;
    private int _val;
    private int _prec;

    public MathNum() {
        _val = Integer.MIN_VALUE;
        _prec = _def_prec;
    }

    public MathNum(int n) {
        _val = n;
        _prec = _def_prec;
    }

    public MathNum(int n, int p) {
        _val = n;
        _prec = p;
    }

    public int val() {
        return _val;
    }

    public static void setDefPrec(int p) {
        _def_prec = p;
    }

    public void setVal(int n) {
        _val = n;
    }

    public void setPrec(int p) {
        _prec = p;
    }

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

    public int lcm(MathNum other) {
        if (this._val > other._val)
            return (this._val / this.gcd(other)) * other._val;
        else
            return (other._val / other.gcd(this)) * this._val;
    }

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
