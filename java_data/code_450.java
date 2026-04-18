import java.util.*;
class Gauss {
		public static double[] solveLGS(double[][] coeff, double[] in) {
		int m=coeff.length, n=coeff[0].length;
		double[][] inp = new double[m][n];
		for (int i=0;i<m;i++)
			inp[i][0] = in[i];
		double[][] re = gaussJordan(coeff,inp);
		double[] r = new double[m];
		for (int i=0; i<m; i++)
			r[i] = re[i][0];
		return r;
	}

			public static double[][] gaussJordan(double[][] coeff, double[][] in) {
		int m=coeff.length, n=coeff[0].length;
		double[][] ext = new double[m][2*n];
		for (int i=0; i<m; i++) { 			for (int j=0; j<n; j++)
				ext[i][j] = coeff[i][j];
			for (int j=0; j<n; j++)
				ext[i][j+n] = in[i][j];
		}
		for (int lc=0; lc<m && lc<n; lc++){ 			int c=lc,l=lc; br:
			for(;c<n;c++,l=lc)
				for(;l<m;l++)
					if (!(ext[l][c]==0))
						break br;

									double[] tmp = new double[2*n];
			double top = ext[l][c];
									if (l>lc)
				tmp = ext[lc].clone();
			for (int j=lc; j<2*n; j++)
				ext[lc][j] = ext[l][j]/top;
			if (l>lc)
				ext[l] = tmp.clone();

						for (int i=lc+1; i<m; i++)
				for (int j=2*n-1; j>=c; j--)
					ext[i][j] -= ext[i][c]*ext[lc][j];
		}
				for (int i=m-1; i>0; i--)
			for (int i2=i-1; i2>=0; i2--)
				for (int j=2*n-1; j>i2; j--)
					ext[i2][j] -= ext[i2][i]*ext[i][j];
				double[][] r = new double[m][n];
		for (int i=0; i<m; i++)
			for (int j=0; j<n; j++)
				r[i][j] = ext[i][j+n];
		return r;
	}

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int T = sc.nextInt();
		while (T --> 0) {
			double[][] m = new double[7][7];
			for(int i = 0; i < 7; i++)
				for(int j = 0; j < 7; j++)
					m[i][j] = sc.nextInt();

			double[][] unit = new double[7][7];
			for(int i = 0; i < 7; ++i)
				unit[i][i] = 1;

			double[][] res = gaussJordan(m,unit);
			for(int i = 0; i < 7; ++i) {
				for(int j = 0; j < 7; ++j)
					System.out.printf("%.03f \t", res[i][j]);
				System.out.println();
			}
			System.out.println();
		}
		Mat m2 = new Mat(3,3);
		double[][] in = {{1,1,1},{4,2,1},{9,3,1}};
		m2.el = in;
		Vec v2 = new Vec(3);
		double[] co = {0,1,3};
		v2.co =  co;
		Vec result = m2.solveLGS(v2);
		System.out.println(Arrays.toString(result.co));
	}
}