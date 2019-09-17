Metodo de Eliminação de Gauss

Ax = b

A e B -> Aa = [A b]
xi = bi - somatorio (j = i+1 -> n(aij * xj))/aii
Matrix A = "2,3,-1;-1,1,4;1-8-,";
Matrix b = "0,3,1";
Aa = A|b;
nLin = Aa.getNumberofRows();
nCol = Aa.getNumberofColumns();

for(i = 1 ; i< nCol - 1;++i ){
  for(j = i+1; j<= nLin; ++j){
    double m = Aa(j,i)/Aa(i,i)
      for( k = 1; k<= nCol; ++k)
      Aa(j,k) = Aa(j,k) - m*Aa(i,k);
      
String Aa


X (nLin,1);
for ( i = nLin; i > 0; --1)
  double sum = 0;
  for( j = i + 1;  j < nCol; ++j)
   dum += Aa(i,j)*X(j,i);
   X(i,1) = (Aa(i,nCol) - sum)/Aa(i,i)
  
