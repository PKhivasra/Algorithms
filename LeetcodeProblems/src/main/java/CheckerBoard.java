/*
import java.util.Arrays;

public class CheckerBoard {

public static int MAXN = 1000+5;

  int n;
  int a[][] = new int[MAXN][5];
  int dp[][][] = new int[MAXN][5][5];

  int go(int i,int j,int k){
    if(i==n) return 0;
    int ans =dp[i][j][k];
    if(ans!=-1) return ans;
    ans=go(i+1,0,0);
    for(int h=1;h<=4;h++) if(h!=j&&h!=k) ans=Math.max(ans,a[i][h]+go(i
        +1,0,h));
    if(j!=1&&k!=3) ans=Math.max(ans,a[i][1]+a[i][3]+go(i+1,1,3));
    if(j!=1&&k!=4) ans=Math.max(ans,a[i][1]+a[i][4]+go(i+1,1,4));
    if(j!=2&&k!=4) ans=Math.max(ans,a[i][2]+a[i][4]+go(i+1,2,4));
    return ans;
  }

  int main(){
    scanf("%d",&n);
//Set 'dp' array to -1 initially
    Arrays.fill(dp,-1);
    for(int i=0;i<n;i++) for(int j=1;j<=4;j++) scanf("%d",&a[i][j]);
    int ans=go(0,0,0);//maximum value
    printf("%d\n",ans);
    return 0;
  }

}
*/
