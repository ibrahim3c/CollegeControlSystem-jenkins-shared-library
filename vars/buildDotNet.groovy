def call() {
    echo "Restoring and Building .NET Solution..."
    sh 'dotnet build CollegeControlSystem.sln -c Release'
}