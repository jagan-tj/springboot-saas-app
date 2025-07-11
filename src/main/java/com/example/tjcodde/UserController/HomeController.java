// Alternative HomeController.java - Returns HTML directly
package com.example.tjcodde.UserController;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LeetCode Learning Automation</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .container {
            background: white;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 100%;
            text-align: center;
            position: relative;
            overflow: hidden;
        }

        .container::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 4px;
            background: linear-gradient(90deg, #ff6b6b, #4ecdc4, #45b7d1, #96ceb4);
        }

        h1 {
            color: #333;
            margin-bottom: 10px;
            font-size: 2.2em;
            font-weight: 700;
        }

        .subtitle {
            color: #666;
            margin-bottom: 30px;
            font-size: 1.1em;
            line-height: 1.5;
        }

        .feature-list {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 30px;
            text-align: left;
        }

        .feature-list h3 {
            color: #333;
            margin-bottom: 15px;
            text-align: center;
        }

        .feature-list ul {
            list-style: none;
            color: #555;
        }

        .feature-list li {
            padding: 8px 0;
            position: relative;
            padding-left: 25px;
        }

        .feature-list li::before {
            content: '✓';
            position: absolute;
            left: 0;
            color: #4ecdc4;
            font-weight: bold;
        }

        .form-group {
            margin-bottom: 25px;
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333;
            font-weight: 600;
        }

        input[type="email"] {
            width: 100%;
            padding: 15px;
            border: 2px solid #e1e5e9;
            border-radius: 10px;
            font-size: 16px;
            transition: all 0.3s ease;
            background: #fff;
        }

        input[type="email"]:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }

        .submit-btn {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 15px 40px;
            border: none;
            border-radius: 10px;
            font-size: 18px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            width: 100%;
            margin-bottom: 20px;
        }

        .submit-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(102, 126, 234, 0.3);
        }

        .submit-btn:active {
            transform: translateY(0);
        }

        .submit-btn:disabled {
            background: #ccc;
            cursor: not-allowed;
            transform: none;
            box-shadow: none;
        }

        .message {
            padding: 15px;
            border-radius: 10px;
            margin-top: 20px;
            font-weight: 600;
            display: none;
        }

        .success {
            background: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }

        .error {
            background: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }

        .loading {
            display: none;
            margin-top: 10px;
        }

        .spinner {
            border: 3px solid #f3f3f3;
            border-top: 3px solid #667eea;
            border-radius: 50%;
            width: 30px;
            height: 30px;
            animation: spin 1s linear infinite;
            margin: 0 auto;
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }

        .footer {
            margin-top: 30px;
            padding-top: 20px;
            border-top: 1px solid #eee;
            color: #666;
            font-size: 14px;
        }

        @media (max-width: 600px) {
            .container {
                padding: 30px 20px;
                margin: 10px;
            }
            
            h1 {
                font-size: 1.8em;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🚀 LeetCode Learning Automation</h1>
        <p class="subtitle">Get personalized LeetCode problems delivered to your Gmail daily!</p>
        
        <div class="feature-list">
            <h3>What You'll Get:</h3>
            <ul>
                <li>Daily LeetCode problems sent to your email</li>
                <li>Curated questions based on difficulty levels</li>
                <li>Track your coding progress automatically</li>
                <li>Free service to boost your programming skills</li>
            </ul>
        </div>

        <form id="emailForm">
            <div class="form-group">
                <label for="email">Enter Your Gmail Address:</label>
                <input type="email" id="email" name="email" required placeholder="your.email@gmail.com">
            </div>
            
            <button type="submit" class="submit-btn" id="submitBtn">
                Start My LeetCode Journey
            </button>
            
            <div class="loading" id="loading">
                <div class="spinner"></div>
                <p>Registering your email...</p>
            </div>
        </form>

        <div id="message" class="message"></div>

        <div class="footer">
            <p>🔒 Your email is secure and will only be used for sending LeetCode problems.</p>
            <p>Built with Spring Boot & MySQL</p>
        </div>
    </div>

    <script>
        document.getElementById('emailForm').addEventListener('submit', async function(e) {
            e.preventDefault();
            
            const email = document.getElementById('email').value;
            const submitBtn = document.getElementById('submitBtn');
            const loading = document.getElementById('loading');
            const message = document.getElementById('message');
            
            // Validate Gmail specifically
            if (!email.endsWith('@gmail.com')) {
                showMessage('Please enter a valid Gmail address ending with @gmail.com', 'error');
                return;
            }
            
            // Show loading state
            submitBtn.disabled = true;
            loading.style.display = 'block';
            message.style.display = 'none';
            
            try {
                const response = await fetch('/users', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        email: email
                    })
                });
                
                if (response.ok) {
                    const data = await response.json();
                    showMessage('🎉 Success! Your email has been registered. You\\'ll start receiving LeetCode problems soon!', 'success');
                    document.getElementById('email').value = ''; // Clear the form
                } else if (response.status === 409) {
                    showMessage('This email is already registered! You should already be receiving LeetCode problems.', 'error');
                } else {
                    throw new Error('Registration failed');
                }
            } catch (error) {
                console.error('Error:', error);
                showMessage('❌ Oops! Something went wrong. Please try again later.', 'error');
            } finally {
                // Hide loading state
                submitBtn.disabled = false;
                loading.style.display = 'none';
            }
        });
        
        function showMessage(text, type) {
            const message = document.getElementById('message');
            message.textContent = text;
            message.className = `message ${type}`;
            message.style.display = 'block';
            
            // Auto-hide success messages after 5 seconds
            if (type === 'success') {
                setTimeout(() => {
                    message.style.display = 'none';
                }, 5000);
            }
        }
        
        // Real-time email validation
        document.getElementById('email').addEventListener('input', function(e) {
            const email = e.target.value;
            const message = document.getElementById('message');
            
            if (email && !email.endsWith('@gmail.com') && email.includes('@')) {
                showMessage('Please use a Gmail address (@gmail.com)', 'error');
            } else if (message.classList.contains('error')) {
                message.style.display = 'none';
            }
        });
    </script>
</body>
</html>
                """;
    }
}