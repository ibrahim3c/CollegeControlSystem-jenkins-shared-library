def call() {
    echo "Running Unit Tests..."
    sh 'dotnet test CollegeControlSystem.sln -c Release --no-build --logger "trx;LogFileName=test_results.trx"'
}