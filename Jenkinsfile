pipeline {
    agent any

    stages {
        // Etapa para parar tdos los servicios
        stage('Parando los servicios') {
            steps {
                script {
                    echo 'Deteniendo contenedores (Windows)...'
                    // Detener y eliminar contenedores y volúmenes asociados
                    bat '''
                        docker compose -p jcgr-demo down -v || echo Compose down falló, intentando docker rm
                        docker rm -f demo2-database demo2-server demo2-client 2>nul || echo No hay contenedores para eliminar
                        exit /b 0
                        '''
                }
            }
        }

        // Elimianr las imagenes anteriores  
        stage('Borrando imagenes antiguas') {
    steps {
        script {
            echo 'Eliminando imagenes antiguas...'
            bat '''
                @echo off
                for /f "delims=" %%a in ('docker images -q jcgr-demo') do (
                    echo Eliminando imagen %%a
                    docker rmi -f %%a || echo Falló al eliminar %%a
                )
                exit /b 0
            '''
        }
    }
}

        // Bajar la ctualizacion mas reciente
        stage('Actualizando..') {
            steps {
                checkout scm
            }
        }

        // Ñevantar y despegar el proyecto
        stage('Levantando los servicios') {
            steps {
                script {
                    echo 'Levantando contenedores...'
                    bat 'docker compose -p jcgr-demo up -d --build'
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline finalizado.'
        }
        success {
            echo 'Pipeline ejecutado exitosamente.'
        }
        failure {
            echo 'Error al ejecutar el pipeline.'
        }
    }
}