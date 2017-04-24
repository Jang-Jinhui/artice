<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<body>
    <form action="save" method="post">
        <div>
            <label>Subject
                <input type="text" name="subject">
            </label>
        </div>
        <div>
            <label>Content
                <textarea name="content"></textarea>
            </label>
        </div>
        <div>
            <button type="submit">Save</button>
            <button type="reset">Cancel</button>
        </div>
    </form>
</body>